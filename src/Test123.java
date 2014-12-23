import java.util.HashMap;
import java.util.Map;


public class Test123 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();

        for( int i = 0; i < 10; i++ )
        {
            map.putIfAbsent( i, "val" + i );
        }

        map.forEach( ( id, val ) -> System.out.println( val ) );

        map.computeIfPresent( 3, ( num, val ) -> val + num );
        System.out.println( map.get( 3 ) ); // val33

	}

}
