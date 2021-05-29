# Periodic Table App

This is my APCS final project. It allows the user to view the periodic table of elements in an interactive way. They can be color coded by metal type, group type, or electronegativity. The user can click on every element to view more information about it in a new window. The user can also copy information about an element to their clipboard from the information panel. All windows contain keyboard shortcuts for simple navigation. The periodic table of elements song plays by pressing a button or a keyboard shortcut.

## Instructions

Start the program by calling `Main.main()`
* In the periodic table window you can:
  * Click on an element to view its information.
  * Click on the "Metal Types" button to color elements by metal, nonmetal, and metalloid.
  * Click on the "Element Groups" button to color elements by more specific groupings.
  * Click on the "Electronegativity" button to color elements based on their electronegativity.
  * Click on the "Element Song" button to play the [elements song by Tom Lehrer](https://www.youtube.com/watch?v=zGM-wSKFBpo).
* In an element information panel you can:
  * Click on the element card to return to the periodic table.
  * Click on the "Copy to clipboard" button to copy the element information to your clipboard.
  
* Keyboard shortcuts:
  * On the main page:
    * Press `M` to switch to metal coloring.
    * Press `G` to switch to group coloring.
    * Press `E` to switch to electronegativity coloring.
    * Press `S` to play and stop the elements song.
  * On an info page:
    * Press `B` to go back to the main page.
    * Press `C` to copy the element information to your clipboard.
    * Press the left arrow key to go to the previous element.
    * Press the right arrow key to go to the next element.

## Functionality

* The project is split into 4 main directories:
  * `frames`: contains classes that control whole windows for the program.
  * `listeners`: contains classes that control events like button and key presses.
  * `panels`: contains classes that control individual panels for the program.
  * The main directory: contains classes for the core functionality of the program.
* Each class/enum and its functionality:
  * `Main.java`: contains the `main()` method to start the program.
  * `PeriodicTableApp.java`: contains the two window objects and controls when to hide and show what.
  * `Element.java`: contains the properties for each element in the periodic table.
  * `MainFrame.java`: contains code to create the periodic table, legend, and buttons.
    * `MetalLegendPanel`: creates the legend panel for the metal coloring view.
    * `FamilyLegendPanel`: creates the legend panel for the family/group coloring view.
    * `ElectronegativityLegendPanel`: creates the legend panel for the electronegativity coloring view.
    * `ColoredLabel`: creates a single colored box and text for use in legend panels.
    * `ButtonPanel`: creates the grid of buttons to control the program.
  * `ElementFrame.java`: contains code to create the individual element information panels.
  * `ElectronegativityColorListener`: listener class to use in buttons on the main page.
  * `FamilyColorListener`: listener class to use in buttons on the main page.
  * `MetalColorListener`: listener class to use in buttons on the main page.
  * `SongListener`: listener class to use in buttons on the main page.
  * `BlankCard.java`: class to create a rectangle `JPanel` at the specified size.
  * `ElementCard.java`: class to create an "element tile," which is the squares that appear on the periodic table and the information windows.
  * `NumberCard.java`: class to create a tile with a number on it that appear on the periodic table as group and period labels.

## Sources
* [Wikipedia List of Elements](https://en.wikipedia.org/wiki/Chemical_element) for element information.
* [Ptable](https://ptable.com/) for element information.
* [Java™ Tutorials](https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html) for help with `GridBagLayout`.
* [Stack Overflow post](https://stackoverflow.com/a/2442614/13335308) for centering a `JFrame` on the screen 
* [GeeksforGeeks article](https://www.geeksforgeeks.org/play-audio-file-using-java/) for playing music with Java.
* [Periodic Table of Elements Song](https://www.youtube.com/watch?v=zGM-wSKFBpo) for the song to include in the project.
* [Camshaft54](https://github.com/Camshaft54) for helping me with keyboard shortcuts.
* [Stack Overflow post](https://stackoverflow.com/a/6713290/13335308) for copying text to the clipboard.
