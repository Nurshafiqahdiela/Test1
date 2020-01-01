/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

/**
 *
 * @author Asus
 */
public class data2 {
    
    private String login;
    private String Repo;
    private String Followers;
    private String Following;
    private String githubLink;


    public data2 (String login, String Repo, String Followers)
    {
        super();
        this.login = login;
        this.Repo = Repo;
        this.Followers = Followers;
        
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRepo() {
        return Repo;
    }

    public void setRepo (String Repo) {
        this.Repo = Repo;
    }

    public String getFollowers() {
        return Followers;
    }

    public void setFollowers(String Followers) {
        this.Followers = Followers;
    }

   

    
}
