package H_Generics.Lab.Jar;

class Main {
    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<Integer>();
        jar.add(1);
        System.out.println(jar.remove());

        JarOfPickles jarOfPickles = new JarOfPickles();
        jarOfPickles.add(new Pickle("abc"));
        System.out.println(jarOfPickles.getNameBig(jarOfPickles.peek()));
        jarOfPickles.remove();
    }
}
