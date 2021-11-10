import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Project name(项目名称)：Map新增的方法
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/10
 * Time(创建时间)： 14:15
 * Version(版本): 1.0
 * Description(描述)：
 * 名称说明
 * Object compute(Object key, BiFunction remappingFunction)
 * 该方法使用 remappingFunction 根据原 key-value 对计算一个新 value。
 * 只要新 value 不为 null，就使用新 value 覆盖原 value；如果原 value 不为 null，但新 value 为 null，则删除原 key-value 对；
 * 如果原 value、新 value 同时为 null，那么该方法不改变任何 key-value 对，直接返回 null。
 * <p>
 * Object computeIfAbsent(Object key, Function mappingFunction)
 * 如果传给该方法的 key 参数在 Map 中对应的 value 为 null，
 * 则使用 mappingFunction 根据 key 计算一个新的结果，如果计算结果不为 null，则用计算结果覆盖原有的 value。
 * 如果原 Map 原来不包括该 key，那么该方法可能会添加一组 key-value 对。
 * <p>
 * Object computeIfPresent(Object key, BiFunction remappingFunction)
 * 如果传给该方法的 key 参数在 Map 中对应的 value 不为 null，该方法将使用 remappingFunction 根据原 key、value 计算一个新的结果，
 * 如果计算结果不为 null，则使用该结果覆盖原来的 value；如果计算结果为 null，则删除原 key-value 对。
 * <p>
 * void forEach(BiConsumer action)
 * 该方法是 Java 8 为 Map 新增的一个遍历 key-value 对的方法，通过该方法可以更简洁地遍历 Map 的 key-value 对。
 * <p>
 * Object getOrDefault(Object key, V defaultValue)
 * 获取指定 key 对应的 value。如果该 key 不存在，则返回 defaultValue。
 * <p>
 * Object merge(Object key, Object value, BiFunction remappingFunction)
 * 该方法会先根据 key 参数获取该 Map 中对应的 value。如果获取的 value 为 null，
 * 则直接用传入的 value 覆盖原有的 value（在这种情况下，可能要添加一组 key-value 对）；如果获取的 value 不为 null，
 * 则使用 remappingFunction 函数根据原 value、新 value 计算一个新的结果，并用得到的结果去覆盖原有的 value。
 * <p>
 * Object putIfAbsent(Object key, Object value)
 * 该方法会自动检测指定 key 对应的 value 是否为 null，
 * 如果该 key 对应的 value 为 null，该方法将会用新 value 代替原来的 null 值。
 * <p>
 * Object replace(Object key, Object value)
 * 将 Map 中指定 key 对应的 value 替换成新 value。与传统 put() 方法不同的是，该方法不可能添加新的 key-value 对。
 * 如果尝试替换的 key 在原 Map 中不存在，该方法不会添加 key-value 对，而是返回 null。
 * <p>
 * boolean replace(K key, V oldValue, V newValue)
 * 将 Map 中指定 key-value 对的原 value 替换成新 value。如果在 Map 中找到指定的 key-value 对，则执行替换并返回 true，否则返回 false。
 * <p>
 * replaceAll(BiFunction function)
 * 该方法使用 BiFunction 对原 key-value 对执行计算，并将计算结果作为该 key-value 对的 value 值。
 */

public class test
{
    public static int getIntRandom(int min, int max)         //空间复杂度和时间复杂度更低
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static int getIntRandom1(int min, int max)          //获取int型的随机数
    {
        if (min > max)
        {
            min = max;
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", getIntRandom1(100, 200));
        map.put("key2", getIntRandom(100, 200));
        map.put("key3", getIntRandom(100, 200));
        map.put("key4", getIntRandom(100, 200));
        map.put("key5", getIntRandom(100, 200));
        map.put("key6", getIntRandom(100, 200));
        map.put("key7", getIntRandom(100, 200));
        map.put("key8", getIntRandom(100, 200));
        map.put("key9", getIntRandom(100, 200));
        System.out.println("输出：");
        for (String s : map.keySet())
        {
            System.out.println(s + " " + map.get(s));
        }
        //将 Map 中指定 key 对应的 value 替换成新 value。与传统 put() 方法不同的是，
        // 该方法不可能添加新的 key-value 对。如果尝试替换的 key 在原 Map 中不存在，该方法不会添加 key-value 对，而是返回 null。
        System.out.println("key10替换结果：" + map.replace("key10", 50));
        System.out.println("key1替换结果：" + map.replace("key1", 50));
        System.out.println("输出：");
        System.out.println(map);
        // 使用原value与传入参数计算出来的结果覆盖原有的value
        System.out.println("使用原value与传入参数计算出来的结果覆盖原有的value:");
        map.merge("key2", 4, (oldVal, param) -> (Integer) oldVal + (Integer) param);
        System.out.println(map);
        // 当key为"Java"对应的value为null (或不存在)时，使用计算的结果作为新value
        System.out.println("当key为\"Java\"对应的value为null (或不存在)时，使用计算的结果作为新value");
        //如果传给该方法的 key 参数在 Map 中对应的 value 为 null，
        // 则使用 mappingFunction 根据 key 计算一个新的结果，如果计算结果不为 null，则用计算结果覆盖原有的 value。
        // 如果原 Map 原来不包括该 key，那么该方法可能会添加一组 key-value 对。
        map.computeIfAbsent("key10", (key) -> ((String) key).length());
        System.out.println(map);
        map.computeIfAbsent("key3", (key) -> ((String) key).length());
        System.out.println(map);
        // 当key为"Java"对应的value存在时，使用计算的结果作为新value
        System.out.println("当key为\"Java\"对应的value存在时，使用计算的结果作为新value");
        //如果传给该方法的 key 参数在 Map 中对应的 value 不为 null，
        // 该方法将使用 remappingFunction 根据原 key、value 计算一个新的结果，如果计算结果不为 null，则使用该结果覆盖原来的 value；
        // 如果计算结果为 null，则删除原 key-value 对。
        map.computeIfPresent("key11", (key, value) -> (Integer) value * (Integer) value);
        System.out.println(map);
        map.computeIfPresent("key4", (key, value) -> (Integer) value * (Integer) value);
        System.out.println(map);
        System.out.println("将 Map 中指定 key-value 对的原 value 替换成新 value。\n" +
                "如果在 Map 中找到指定的 key-value 对，则执行替换并返回 true，否则返回 false:");
        System.out.println(map.replace("key1", 20, 99));
        System.out.println(map);
        System.out.println(map.replace("key1", 50, 99));
        System.out.println(map);
        System.out.println("值全部+2：");
        //该方法使用 BiFunction 对原 key-value 对执行计算，并将计算结果作为该 key-value 对的 value 值。
        map.replaceAll((key, value) -> value + 2);
        System.out.println(map);
        System.out.println();
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
