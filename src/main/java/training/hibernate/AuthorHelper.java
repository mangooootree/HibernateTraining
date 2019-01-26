package training.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import training.hibernate.entity.Author;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AuthorHelper {


    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList(){
        Session session = sessionFactory.openSession();
        session.get(Author.class, 1L);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class);
        cq.select(root);

        Query query = session.createQuery(cq);
        List<Author> authors = query.getResultList();

        session.close();

        return authors;

    }

    public Author saveAuthor(Author author){
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(author);

        session.getTransaction().commit();

        session.close();

        return author;
    }
}
