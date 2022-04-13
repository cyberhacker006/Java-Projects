import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import enigma.console.Console;
import enigma.console.TextAttributes;
import java.awt.Color;
public class Clear_screen {              // clears screen inside j and i coordinates

	static void clear(Console cn) {
		for(int j = 0; j < 100; j++) {
			for(int i = 0; i < 100; i++) {
				cn.getTextWindow().setCursorPosition(i, j);
				cn.getTextWindow().output(" ");
			}
		}
		cn.getTextWindow().setCursorPosition(0,0);
		
	}
}
