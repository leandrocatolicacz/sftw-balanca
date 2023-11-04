package interfaces;

import java.util.List;

public interface Balanca<T> {
    void export(List<T> products, String path);
}
