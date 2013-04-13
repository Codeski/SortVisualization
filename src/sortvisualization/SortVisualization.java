package sortvisualization;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SortVisualization {

	private static final int ARRAY_LENGTH = 100;
	private static final int HEIGHT = 600;

	@SuppressWarnings("unused")
	private static final int WIDTH = ARRAY_LENGTH > 200 ? ARRAY_LENGTH * 4 : 800;
	private static final int TEXT_HEIGHT = 59;
	private static final int MIN = (int)(HEIGHT * 0.1);
	private static final int MAX = (int)((HEIGHT - TEXT_HEIGHT) * 0.9);

	private static Number[] array = new Number[ARRAY_LENGTH];

	private static Window window;
	private static Canvas canvas;

	public static void main(String args[]) {
		int[] sizes = {256, 128, 64, 48, 32, 24, 16};
		ArrayList<Image> icons = new ArrayList<Image>();
		for (int i : sizes)
			icons.add(new ImageIcon(SortVisualization.class.getClassLoader().getResource("icon" + i + ".png")).getImage());
		if (System.getProperty("os.name").equals("Mac OS X")) {
			com.apple.eawt.Application application = com.apple.eawt.Application.getApplication();
			application.setDockIconImage(icons.get(0));
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "SortVisualization");
			System.setProperty("apple.laf.useScreenMenuBar", "true");
		}
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		AudioEngine.nop();
		new Thread(new Randomize(ARRAY_LENGTH, MIN, MAX)).start();
		window = new Window();
		canvas = new Canvas();
		window.add(canvas);
		window.setSize(canvas.getWidth(), canvas.getHeight());
		window.setIconImages(icons);
		window.setVisible(true);
	}

	public static Number[] getArray() {
		return array;
	}

	public static void setArray(Number[] array) {
		SortVisualization.array = array;
	}

	public static Canvas getCanvas() {
		return canvas;
	}

}