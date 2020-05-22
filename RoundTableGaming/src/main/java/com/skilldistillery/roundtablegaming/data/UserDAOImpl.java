package com.skilldistillery.roundtablegaming.data;

import javax.persistence.Persistence;

import com.skilldistillery.roundtablegaming.entities.User;

@Service
@Transactional
public class UserDAOImpl implements UserDAO{


	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(int id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}

//public class ActorDAOImpl implements ActorDAO {
//	
//	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
//
//	@Override
//	public Actor create(Actor actor) {
//		EntityManager em = emf.createEntityManager();
//		System.out.println(em.getClass());
//		System.out.println("Before begin(): " + actor);
//		em.getTransaction().begin();
//		System.out.println("After begin(), before persist(): " + actor);
//		try {
//			em.persist(actor);
//			System.out.println("After persist(), before flush(): " + actor);
//			em.flush();
//			System.out.println("After flush(), before commit(): " + actor);
//			em.getTransaction().commit();
//			System.out.println("After commit(): " + actor);
//			em.close();
//		} catch (Exception e) {
////			e.printStackTrace();
//			System.err.println(e.getMessage());
//			em.getTransaction().rollback();
//			System.out.println("After rollback(): " + actor);
//			em.close();
//		}
////		em.close();
//		return actor;
//	}
//
//	@Override
//	public Actor update(int id, Actor actor) {
//		EntityManager em = emf.createEntityManager();
//		Actor managed = em.find(Actor.class, id);
//		if (managed != null) {
//			em.getTransaction().begin();
//			managed.setFirstName(actor.getFirstName());
//			managed.setLastName(actor.getLastName());
//			em.flush();
//			em.getTransaction().commit();
//		}
//		return managed;
//	}
//
//	@Override
//	public boolean destroy(int id) {
//		EntityManager em = emf.createEntityManager();
//		boolean deleted = false;
//		Actor managed = em.find(Actor.class, id);
//		if ( managed != null ) {
//			em.getTransaction().begin();
//			em.remove(managed);
//			em.getTransaction().commit();
//			deleted = true;
//		}
//		return deleted;
//	}