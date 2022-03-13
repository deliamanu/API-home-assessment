package com.challenge;


import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestChain {
    User firstUser;
    User secondUser;
    SocialNetwork socialNetwork;
    int shortestChain;

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

    public int getShortestChain() {
        return this.shortestChain;
    }

    public void computeShortestChain() {
        Queue<User> queue = new PriorityQueue<>();
        queue.add(firstUser);


    }
}
