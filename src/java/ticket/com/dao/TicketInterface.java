
package ticket.com.dao;

import java.util.List;

/**
 *
 * @author Emrul
 */
public interface TicketInterface<T> {
     public boolean insert(T obj);

    public boolean update(T obj);

    public boolean delete(T obj);

    public boolean search(T obj);
    
    public T getObjectById(int id);

    public T getObjectByName(T name);

    public List<T> getAllObject();
    
    public List<T> getListById(int id);
    
    public List<T> getListByName(T obj);
    
    
}
