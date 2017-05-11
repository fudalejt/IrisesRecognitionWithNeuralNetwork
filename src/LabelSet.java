import java.util.ArrayList;

public class LabelSet<T> extends ArrayList<T>{
	private static final long serialVersionUID = 8044053832621529824L;
	
	public int getIndex(T element){		
		for(int i = 0; i < size(); i++)
		{
			if(element.equals(get(i)))
				return i;
		}
		return -1;
	}
}
