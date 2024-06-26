public class numExpo {
    public static void main(String[] args) {
        Long a = 2L;
        Long b = 31L;
        Long result = 1L;
        System.out.println(calculate_power(a,b, result));
        System.out.println(result.intValue());
    }

    public static Long calculate_power(Long  a, Long b, Long powerofa) {
        if(b == 1)
            return powerofa * a;

        powerofa  = (Long) (a * calculate_power(a,b-1, powerofa));
        return powerofa;

    }
}
