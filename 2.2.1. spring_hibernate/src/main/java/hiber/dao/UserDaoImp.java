package hiber.dao;

import com.mysql.cj.Query;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   public User getUser(int series, String model){
      TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery(("FROM Car where model = :paramName and series = :paramName2"));
      query.setParameter("paramName",model);
      query.setParameter("paramName2",series);

      User user = query.getSingleResult().getUser();
      return user;
   }

}
