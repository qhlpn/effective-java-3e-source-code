package effectivejava.chapter5.item33;

import java.util.*;

// 考虑类型安全的异构容器
// 参数化容器  ->  异构容器
// 与参数化容器 Map<K. V> 不同，异构容器 Map<Class<?>, Object> 所有键都是不同类型的

// 异构容器提供更大的灵活性。
// 例如，一个数据库行可以有任意多列，能够以类型安全的方式访问所有这些列。
// 其思想是参数化键而不是容器。然后向容器提供参数化键以插入或检索值。泛型类型系统用于确保值的类型与键一致。
public class n1_Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorite(Class<T> type) {
        // Class.cast
        return type.cast(favorites.get(type));
    }

//    // Achieving runtime type safety with a dynamic cast
//    public <T> void putFavorite(Class<T> type, T instance) {
//        favorites.put(Objects.requireNonNull(type), type.cast(instance));
//    }

    public static void main(String[] args) {
        n1_Favorites f = new n1_Favorites();
        f.putFavorite(String.class, "Java");
//        f.putFavorite(String.class, 100);   // 编译出错
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, n1_Favorites.class);
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }
}