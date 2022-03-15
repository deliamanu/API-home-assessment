package com.challenge;

import java.util.*;

public class Main {
    /**
     * In main I made different tests for the algorithm that computes the length of the shortest chain of friends between A(first user) and B(second user)
     */
    public static void main(String[] args) {
        User user1 = new User("maria");
        User user2 = new User("david");
        User user3 = new User("dana1");
        User user4 = new User("delia");
        User user5 = new User("pavel3");
        User user6 = new User("ana00");
        User user7 = new User("cristi");
        User user8 = new User("joe194");
        User user9 = new User("simona");
        User user10 = new User("louis");
        User user11 = new User("vladut");
        User user12 = new User("adi100");
        User user13 = new User("nofriend");

        List<User> list = List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10,user11,user12,user13);
        SocialNetwork socialNetwork = new SocialNetwork(list);

        socialNetwork.addFriends(user1, List.of(user2, user4));
        socialNetwork.addFriends(user2, List.of(user1, user4, user3));
        socialNetwork.addFriends(user3, List.of(user4, user2, user6));
        socialNetwork.addFriends(user4, List.of(user1, user2, user3, user5, user7));
        socialNetwork.addFriends(user5, List.of(user4, user7, user6, user11));
        socialNetwork.addFriends(user6, List.of(user3, user5, user7, user8, user10, user12));
        socialNetwork.addFriends(user7, List.of(user4, user5, user6, user9));
        socialNetwork.addFriends(user8, List.of(user6, user9, user10));
        socialNetwork.addFriends(user9, List.of(user7, user8, user12));
        socialNetwork.addFriends(user10, List.of(user8, user6));
        socialNetwork.addFriends(user11, List.of(user12, user5));
        socialNetwork.addFriends(user12, List.of(user11, user9, user6));

        System.out.println("====================");

        System.out.println("The length of the shortest chain of friends between: ");
        ShortestChain example1 = new ShortestChain(user4, user11, socialNetwork);
        System.out.println(user4 + " and " + user11 + "--->" + example1.getShortestChainLength());
        ShortestChain example2 = new ShortestChain(user2, user8, socialNetwork);
        System.out.println(user2 + " and " + user8 + "--->" + example2.getShortestChainLength());
        ShortestChain example3 = new ShortestChain(user6, user10, socialNetwork);
        System.out.println(user6 + " and " + user10 + "--->" + example3.getShortestChainLength());
        ShortestChain example4 = new ShortestChain(user5, user12, socialNetwork);
        System.out.println(user5 + " and " + user12 + "--->" + example4.getShortestChainLength());
        ShortestChain example5 = new ShortestChain(user1, user12, socialNetwork);
        System.out.println(user1 + " and " + user12 + "--->" + example5.getShortestChainLength());
        ShortestChain example6 = new ShortestChain(user13, user1, socialNetwork);
        System.out.println(user13 + " and " + user1 + "--->" + example6.getShortestChainLength());

        User noUser = new User("nouser");
        ShortestChain example7 = new ShortestChain(user13, noUser, socialNetwork);
        /**
         * Input validation tests
         */
        socialNetwork.addUser(new User("delia"));
        socialNetwork.addUsers(List.of(new User("maria"), new User("liliana")));
        socialNetwork.addFriend(user1, new User("roger"));
        socialNetwork.addFriends(user4, List.of(new User("stewie"), new User("Stefan")));
        socialNetwork.addFriend(user3, user6);
    }

}
