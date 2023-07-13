package com.javaunit3.springmvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class MovieController {
@RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }
    @RequestMapping("/bestMovie")
    public String getBestMoviePage(Model model) {
        model.addAttribute("BestMovie", bestMovieService.getBestMovie().getTitle());
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<MovieEntity> movieEntities = session.createQuery("from MovieEntity").list();
        movieEntities.sort(Comparator.comparing(movieEntity -> movieEntity.getVotes().size()));

        MovieEntity movieWithMostVotes = movieEntities.getMovieEntities.size() - 1);
        List<String> names = new ArrayList<>();

        for (VoteEntity vote: movieWithMostVotes.getVotes()) {
            names.add(vote.getName());
        }

        String voterNamesList = String.join(",", names);

        model.addAttribute("bestMovie", movieWithMostVotes.getTitle());
        model.addAttribute("bestMovieVoters", voterNamesList);

        session.getTransaction().commit();
        
        return "bestMovie";
    }
    @RequestMapping("/voteForBestMovieForm")
    public String voteForBestMovieFormPage(Model model) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<MovieEntity> movieEntities = session.createQuery("from MovieEntity").list();
        session.getTransaction().commit();
        model.addAttribute("movies", movieEntities);
        return "voteForBestMovie";
    }
    
    @RequestMapping("/voteForBestMovie")
    public String voteForBestMovie(HttpServletRequest request, Model model) {
        String movieTitle = request.getParameter("movieTitle");
        model.addAttribute("BestMovieVote", movieTitle);

        String movieId = request.getParameter("movieId");
        String name = request.getParameter("name");

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        MovieEntity movieEntity = (MovieEntity) session.get(MovieEntity.class, Integer.parseInt(movieId));
        VoteEntity newVote = new VoteEntity();
        newVote.setName(name);
        movieEntity.addVote(newVote);

        session.update(movieEntity);
        session.getTransaction().commit();

        return "voteForBestMovie";
    }

    @Autowired
    private SessionFactory sessionFactory;
    @RequestMapping("/addMovieForm")
    public String addMovieForm() {
        return "addMovie";
    }
}


