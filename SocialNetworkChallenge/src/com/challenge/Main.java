package com.challenge;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        User user1 = new User("delia");
        User user2 = new User("vlad-adrian");
        User user3 = new User("pavel");
        User user4 = new User("simona2");
        User user5 = new User("adriana");
        User user6 = new User("cristi10");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(new User("ruxi21"));

        SocialNetwork socialNetwork = new SocialNetwork(users);
        socialNetwork.addUser(new User("Iulian44"));
        socialNetwork.addUser(new User("delia"));
        users.add(user2);
        socialNetwork.addUsers(users);

        socialNetwork.addFriend(user1, user2);
        socialNetwork.addFriend(user1, user3);
        socialNetwork.addFriends(new User("maria"), users);
        socialNetwork.addFriend(user2, user2);

        /**
         * This is an example of a social network with friends and on this social network the function will be tested
         */
        SocialNetwork socialNetworkInput = makeSocialNetwork();
        User firstUser = new User("delia");
        User secondUser = new User("vladut");
    }

    public static SocialNetwork makeSocialNetwork() {

        User user1 = new User("maria123");
        User user2 = new User("dog2000");
        User user3 = new User("dan40");
        User user4 = new User("delia");
        User user5 = new User("pavel2");
        User user6 = new User("ana");
        User user7 = new User("cristi");
        User user8 = new User("joe1994");
        User user9 = new User("simona");
        User user10 = new User("louis3");
        User user11 = new User("vladut");
        User user12 = new User("adrian8");

        List<User> list = List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10,user11,user12);
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

        return socialNetwork;
    }

}
