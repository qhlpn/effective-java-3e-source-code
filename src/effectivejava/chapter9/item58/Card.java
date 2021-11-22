package effectivejava.chapter9.item58;

import java.util.*;


// for-each 循环优于传统的 for 循环
// 1. while 循环容易扩散变量作用域
// 2. for-each 对比 for 循环，隐藏迭代器或索引变量来消除混乱和出错的机会
// 不幸的是，有三种常见的情况你不应使用 for-each：
//      - 破坏性过滤，如果需要遍历一个集合并删除选定元素，则需要使用显式的迭代器，以便调用其 remove 方法
//      - 转换，如果需要遍历一个 List 或数组并替换其中部分或全部元素的值
//      - 并行迭代，如果需要并行遍历多个集合，那么需要显式地控制迭代器或索引变量，以便所有迭代器或索引变量都可以同步执行
public class Card {
    private final Suit suit;
    private final Rank rank;

    enum Suit {CLUB, DIAMOND, HEART, SPADE}

    enum Rank {
        ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING
    }

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        // Can you spot the bug?
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); )
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
                deck.add(new Card(i.next(), j.next()));


        // Fixed, but ugly - you can do better!
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            Suit suit = i.next();
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
                deck.add(new Card(suit, j.next()));
        }

        // Preferred idiom for nested iteration on collections and arrays
        for (Suit suit : suits)
            for (Rank rank : ranks)
                deck.add(new Card(suit, rank));
    }
}
