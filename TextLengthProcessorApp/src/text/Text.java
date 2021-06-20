package text;

import java.io.Serializable;

public class Text implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  String text;
	  int length;
		
		public void setText (String text) {
			this.text = text;
		}
		
		public String getText() {
			return text;
		}	
		
		public void setTextLength(int length) {
			this.length= length;
		}
		
		public int getTextLength() {
			return length;
		}
		
		public int countwords(String text) {
			int j = 0, i = 0, blankspace = 0;

				for ( i = 0, j = text.length(); i < j; i++) {
					char c = text.charAt(i);
				    if (c == ' ' ) {
						blankspace++;
				    }
				}
				return j-blankspace;
		}


}
