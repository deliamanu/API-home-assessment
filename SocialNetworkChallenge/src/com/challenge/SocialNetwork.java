package com.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents a social network with users and the list of friends of every user if it has one.
 * Everytime a user is added to the social network, I made functions that will check if the user is unique
 * and if the user is added like a friend for another user, I made functions that will check if the friend is in the social network
 * and if it is not already in the list of friends.
 */
public class SocialNetwork {
    Map<User, List<User>> users = new HashMap<>();

    public SocialNetwork(List<User> users) {
        if(areUniqueUsers(users)) {
            for(User user : users) {
                this.users.put(user, new ArrayList<User>());
            }
        } else {
            System.out.println("The list of users contains users with the same name");
        }
    }

    public SocialNetwork() {}

    public Map<User, List<User>> getUsers() {
        return this.users;
    }

    public void addUsers(List<User> users) {
        if(areUniqueUsers(users)) {
            for(User user : users) {
                this.users.put(user, new ArrayList<User>());
            }
            System.out.println("The list with users has been added.");
        } else {
            System.out.println("This list contains users with the same name");
        }
    }

    public void addUser(User user) {
        int duplicate = 0;
        for(User key : this.users.keySet()) {
            if(key.equals(user)) {
                System.out.println("You cannot add a user with the same name with another user");
                duplicate = 1;
                break;
            }
        }
        if(duplicate == 0) {
            this.users.put(user, new ArrayList<User>());
            System.out.println(user + " added to the social network");
        }
    }

    public boolean areUniqueUsers(List<User> users) {
        for(int i=0; i < users.size()-1; i++) {
            for(int j=i+1; j<users.size(); j++) {
                if(users.get(i).equals(users.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUser(User user) {
        for(User key : this.users.keySet()) {
            if(key.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFriend(User friend, User user) {
        for(User key : this.users.get(user)) {
            if(key.equals(friend)) {
                return true;
            }
        }
        return false;
    }
    public void addFriends(User user, List<User> friends) {
        int duplicateFriend = 0;
        if(isUser(user)) {
            if (areUniqueUsers(friends)) {
                for(User friend : friends) {
                    if(!isUser(friend) || user.equals(friend) || isFriend(friend, user)) {
                        System.out.println(friend + " is not a user. You cannot add a non user friend, an existing friend or is the same with user.");
                        duplicateFriend = 1;
                        break;
                    }
                }
                if (duplicateFriend == 0) {
                    this.users.put(user, friends);
                    System.out.println("The list of friends for " + user + " was added.");
                }
            } else {
                System.out.println("This list of friends has duplicate users.");
            }
        } else {
            System.out.println("This user doesn't exist. You cannot add a list of friends to an non existing user.");
        }
    }

    public void addFriend(User user, User friend) {
        if(isUser(user) && isUser(friend) && !user.equals(friend) && !isFriend(friend, user)) {
            this.users.get(user).add(friend);
            this.users.put(user, this.users.get(user));
            System.out.println(friend + " was added as a friend to " + user);
        } else {
            System.out.println("The user or the friend doesn't exist, the friend is equal with the user or the friend is already a friend of user");
        }
    }
}
