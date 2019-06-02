package H_Generics.Lab.Jar;

class JarOfPickles extends Jar<Pickle> {

    String getNameBig(Pickle pickle) {
        return pickle.getName().toUpperCase();
    }
}
