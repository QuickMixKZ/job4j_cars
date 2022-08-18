package ru.job4j.cars.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Advert;
import ru.job4j.cars.model.CarBrand;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

@Repository
public class AdRepository {

    private final SessionFactory sessionFactory;

    public AdRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Advert> getCurrentDayAdverts() {
        return tx(session -> {
            Query query = session.createQuery("from Advert where created >= :startOfDay");
            query.setParameter("startOfDay", LocalDate.now().atStartOfDay());
            return query.getResultList();
        });
    }

    public List<Advert> getAdvertsWithPhoto() {
        return tx(session -> session.createQuery("from Advert where photo != null").getResultList());
    }

    public List<Advert> getAdvertsByBrand(CarBrand brand) {
        return tx(session -> session.createQuery("from Advert a join fetch CarBrand b where b = :brand")
                .setParameter("brand", brand)
                .getResultList());
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
