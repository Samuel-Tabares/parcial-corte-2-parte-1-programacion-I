import java.util.List;

public interface Repository<T> {
    void save(T item);
    T findById(int id);
    List<T> findAll();
    void update(T item);
    void delete(int id);
}
