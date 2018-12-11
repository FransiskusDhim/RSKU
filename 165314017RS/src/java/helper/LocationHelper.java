/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import pojos.Location;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class LocationHelper {
    public LocationHelper() {};
    
    public List<Location> bacaSemuaLokasi(){
        Session session = util.HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Location> hasil = null;
        Query q = session.createQuery("from Location l");
        hasil = q.list();
        tx.commit();
        session.close();
        return hasil;
    }
    public static String toJson(){
        LocationHelper helper = new LocationHelper();
        List<Location> list = helper.bacaSemuaLokasi();
        String result = "[";
        for (int i = 0; i < list.size(); i++) {
            if (i < (list.size() - 1)) {
                result += list.get(i).toJson() +", \n";                
            } else {
                result += list.get(i).toJson();
            }
        }
        result+="]";
        return result;
    }
}
