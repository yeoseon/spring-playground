package me.yeoseon;

import me.yeoseon.neo4jaccount.Account;
import me.yeoseon.neo4jaccount.Role;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();

        account.setEmail("devyyskr@gmail.com");
        account.setUserName("yeoseon");

        Role role = new Role();
        role.setName("admin");

        account.getRoles().add(role);

        Session session = sessionFactory.openSession();
        session.save(account);
        sessionFactory.close();
    }
}
