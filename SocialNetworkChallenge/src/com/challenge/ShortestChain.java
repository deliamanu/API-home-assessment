package com.challenge;


import java.util.*;

public class ShortestChain {
    User firstUser;
    User secondUser;
    SocialNetwork socialNetwork;
    int shortestChainLength;

    public ShortestChain(User firstUser, User secondUser, SocialNetwork socialNetwork) {
        for(User key : socialNetwork.getUsers().keySet()) {
            if(key == firstUser) {
                this.firstUser = firstUser;
            }
            if(key == secondUser) {
                this.secondUser = secondUser;
            }
        }
        if(this.firstUser != null && this.secondUser != null && !this.firstUser.equals(this.secondUser)) {
            this.socialNetwork = socialNetwork;
        } else {
            System.out.println(firstUser + " or " + secondUser + " are not in the socialNetwork passed as input or they are equal");
        }
    }

    public int getShortestChainLength() {
        computeShortestChain();
        return this.shortestChainLength;
    }

    /**
     * This function is using the BFS algorithm to find the length of the shortest chain of friends between A(first user) and B(second user).
     */
    private void computeShortestChain() {
        PriorityQueue<User> queue = new PriorityQueue<>(); // in this queue will be added all the friends of the current user that hadn't been visited
        queue.add(firstUser); // initially it contains the first user

        Map<User, Boolean> visited = new HashMap<>(); // this HashMap stores if the user was visited or not
        for(User user : socialNetwork.getUsers().keySet()) {
            visited.put(user, false);
        }
        visited.put(firstUser, true);

        // this HashMap stores the minimum length between the first user and users from the social network
        Map<User, Integer> distances = new HashMap<>();
        for(User user : socialNetwork.getUsers().keySet()) {
            distances.put(user, 0);
        }

        while(!queue.isEmpty()) { // if the queue is not empty we pop the head of the queue
            User topQueueUser = queue.poll();
            List<User> friendsOfUser = socialNetwork.getUsers().get(topQueueUser); //  this list contains all the friends of the user from the head queue
            visited.put(topQueueUser, true);

            for(User friend : friendsOfUser) {
                if (!visited.get(friend)) { // check if the friend is visited or not
                    queue.add(friend); // if not, it will be added to the queue, the visited and distance HashMaps will be updated
                    visited.put(friend, true);
                    distances.put(friend, distances.get(topQueueUser) + 1);
                }
                if(friend.equals(secondUser)) { // if the friend is the second user, we stop because it is no use to find and store the minimum length between the first user and all users
                    break;
                }
            }
        }

        this.shortestChainLength = distances.get(secondUser);
    }
}
