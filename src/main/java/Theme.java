import java.util.ArrayList;
import java.util.List;

public class Theme {


    private String nom;
    private final List<Theme> parents = new ArrayList<>();
    private final List<Theme> sousThemes = new ArrayList<>();

    private final List<Formation> formations = new ArrayList<>();

    // getters & setters


    public void ajouterSousTheme(Theme theme) {
        this.sousThemes.add(theme);
        theme.parents.add(theme);
    }

    public void ajouterFormation(Formation formation) {
        this.formations.add(formation);
    }

    public List<Formation> getToutesFormations() {
        List<Formation> toutes = new ArrayList<>(formations);
        for (Theme sousTheme : sousThemes) {
            toutes.addAll(sousTheme.getToutesFormations());
        }
        return toutes;
    }


    public List<Theme> getParents() {
        return parents;
    }

    public List<Theme> getSousThemes() {
        return sousThemes;
    }

}
