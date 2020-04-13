package src.algorithm.design_twitter;

import java.util.*;
import java.util.stream.Collectors;

public class Twitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<Tweet>());
        }
        tweetMap.get(userId).add(new Tweet(tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (followMap.containsKey(userId)) {
            TreeSet<Tweet> set = new TreeSet<>();
            Set<Integer> temp = followMap.get(userId);
            Iterator it = temp.iterator();
            while (it.hasNext()) {
                set.addAll(tweetMap.getOrDefault(it.next(), new ArrayList<Tweet>()));
            }
            return set.stream().sorted(Collections.reverseOrder()).limit(10).mapToInt(e -> e.getId()).boxed().collect(Collectors.toList());

        } else {
            return tweetMap.containsKey(userId) ? tweetMap.get(userId).stream().sorted(Comparator.reverseOrder()).limit(10).mapToInt(e -> e.getId()).boxed().collect(Collectors.toList()) : new ArrayList<>();
        }
    }

    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<Integer>());
            followMap.get(followerId).add(followerId);
        }
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!followMap.containsKey(followerId)) return;
        followMap.get(followerId).remove(followeeId);
    }

    class Tweet implements Comparable<Tweet> {
        int id;
        long publishTime;

        public Tweet(int tweetId) {
            id = tweetId;
            publishTime = System.nanoTime();
        }

        public int getId() {
            return id;
        }

        @Override
        public int compareTo(Tweet o) {
            return publishTime < o.publishTime ? 1 : -1;
        }
    }
}
