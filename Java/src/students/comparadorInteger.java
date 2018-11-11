package students;

import java.util.Comparator;

public class comparadorInteger implements Comparator<Integer> {

	@Override
	@SuppressWarnings("null")
	public int compare(Integer o1, Integer o2) {
		if(o1 == null || o2 == null)
			return (Integer) null;
		return o1 == o2 ? 0 : (o1 - o2);
	}

}
