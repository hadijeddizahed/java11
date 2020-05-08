package stackoverflow;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question10 {
    public static void main(String[] args) {

        List<Row> rows = List.of(new Row("ar5sg5h", 4, 3, 4),
                new Row("sd6ad6d", 2, 5, 3),
                new Row("ar5sg5h", 6, 5, 6),
                new Row("sd6ad6d", 5, 6, 3),
                new Row("sd6ad6d", 3, 7, 3)
        );

        String str = "Hello, Maria has 30 USD.";
        String[] FORMAT = {"USD", "CAD"};
        final String simbol = "$";

        //  This was the initial implementation.
        //  for (String s: FORMAT) {
        //      str = str.replaceAll(s + "\\s",  "\\" + FORMAT);
        //  }

        Arrays.stream(FORMAT).forEach(country -> {
            str.replaceAll(country + "\\s", "\\" + simbol);
        });

        System.out.println(str);
        List<Item> itemList = new ArrayList<>();

        List<UsersContexts> usersContexts = new ArrayList<>();

        usersContexts.add(new UsersContexts(1l, 1001l));
        usersContexts.add(new UsersContexts(1l, 1002l));
        usersContexts.add(new UsersContexts(1l, 1003l));
        usersContexts.add(new UsersContexts(1l, 1004l));
        usersContexts.add(new UsersContexts(2l, 2001l));
        usersContexts.add(new UsersContexts(2l, 2002l));


//        System.out.println(usersContexts.stream()
//                .map(u -> new UserData(u.getId(), new ArrayList<>(Collections.singletonList(u.getCtx_id()))))
//                .collect(Collectors.toMap(UserData::getId, Function.identity(),
//                        (o, o2) -> {
//                            o.getContextList().addAll(o2.getContextList());
//                            return o;
//                        })).values());

        System.out.println(usersContexts.stream()
                .collect(Collectors.groupingBy(UsersContexts::getId,
                        Collectors.collectingAndThen(Collectors
                                        .mapping(m->new UserData(m.getId(),new ArrayList<>(Collections.singletonList(m.getCtx_id())))
                                                ,Collectors.reducing((t, t2) ->{t.getContextList().addAll(t2.getContextList());return t;}))
                                ,userData -> userData.orElse(null)))).values());


        List<String> pathNames = List.of("/state", "/country", "/country/name");
        List<String> newPaths = List.of("/country/name");

       long allSize = Stream.concat(pathNames.stream(),newPaths.stream()).distinct().count();
        boolean b = allSize == (pathNames.size() + newPaths.size());
        System.out.println(b);
        System.out.println(allSize);
        System.out.println(pathNames.size() + newPaths.size());

        Boolean check = Stream.concat(pathNames.stream(),newPaths.stream()).distinct().count() <(pathNames.size() + newPaths.size());

        System.out.println(check);

    }
}

class UsersContexts {
    long id;
    Long ctx_id;

    public UsersContexts(long id, Long ctx_id) {
        this.id = id;
        this.ctx_id = ctx_id;
    }

    public long getId() {
        return id;
    }

    public Long getCtx_id() {
        return ctx_id;
    }
}

class UserData {
    private long id;
    private List<Long> contextList;

    public UserData(long id, List<Long> contextList) {
        this.id = id;
        this.contextList = contextList;
    }

    public long getId() {
        return id;
    }

    public List<Long> getContextList() {
        return contextList;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", contextList=" + contextList +
                '}';
    }
}

class Item {
    private String id;
    private List<Property> propertyList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }
}

class Property {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class Row {
    private String sku;
    private int colA; // sum
    private int colB; // sum
    private int colC; // avg

    public Row(String sku, int colA, int colB, int colC) {
        this.sku = sku;
        this.colA = colA;
        this.colB = colB;
        this.colC = colC;
    }

    public Row merge(Row row) {
        this.sku = row.sku;
        this.colA += row.colA;
        this.colB += row.colB;
        this.colC = (row.colC + this.colC) / 2;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public int getColA() {
        return colA;
    }

    public int getColB() {
        return colB;
    }

    public int getColC() {
        return colC;
    }

    @Override
    public String toString() {
        return "Row{" +
                "sku='" + sku + '\'' +
                ", colA=" + colA +
                ", colB=" + colB +
                ", colC=" + colC +
                '}';
    }
}