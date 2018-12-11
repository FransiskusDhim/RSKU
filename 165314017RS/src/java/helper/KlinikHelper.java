/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Klinik;
import pojos.Pasien;
import util.NewHibernateUtil;

/**
 *
 * @author MR98X
 */
public class KlinikHelper {
  public List<Klinik> bacaSemuaKlinik() {
        List<Klinik> list = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Klinik l");
        list = q.list();
        tx.commit();
        session.close();
        return list;
    }
    
    
    public void addNewKlinik(String id, String nama, String spesialis) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        Transaction transaction = session.beginTransaction();
        Klinik klinik = new Klinik(id, nama, spesialis);
        session.saveOrUpdate(klinik);
        transaction.commit();
        session.close();
    }
}
