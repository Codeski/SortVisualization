package com.codeski.sortvisualization;

public class SelectionSort extends Sort {
	public SelectionSort(Window window) {
		super(window);
	}

	@Override
	public void run() {
		if (array.length <= 1)
			return;
		for (int i = 0; i < array.length; ++i) {
			int min = i;
			for (int j = i + 1; j < array.length; ++j) {
				if (this.stop())
					return;
				if (array[j].lt(array[min]))
					min = j;
			}
			if (min != i)
				swap(i, min);
		}
	}
}