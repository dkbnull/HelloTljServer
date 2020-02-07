package cn.wbnull.hellotlj.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 扑克发牌工具类
 *
 * @author dukunbiao(null)  2020-02-07
 * https://github.com/dkbnull/HelloTljServer
 */
public class PokerTools {

    private static String[] pokers = new String[52];
    private static boolean[] marks;
    private static final String[] COLORS = {"红桃", "黑桃", "梅花", "方片"};
    private static final String[] NUMBERS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public static void initPokers() {
        int index = 0;
        for (String color : COLORS) {
            for (String number : NUMBERS) {
                pokers[index++] = color + number;
            }
        }

        marks = new boolean[pokers.length];
        initPokerMarks();
    }

    public static void initPokerMarks() {
        if (marks == null) {
            initPokers();
        }

        Arrays.fill(marks, false);
    }

    public static List<String> sendPoker() {
        List<String> sendPoker = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            int index = new Random().nextInt(pokers.length);

            if (!marks[index]) {
                //将未取出的牌加入发牌堆
                sendPoker.add(pokers[index]);
                //修改标识，已发牌标记为true
                marks[index] = true;
            } else {
                //该次取随机数取到的是已发的牌，则重新取一次
                i--;
            }
        }

        return sendPoker;
    }
}
