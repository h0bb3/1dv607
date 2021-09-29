package view;

public class Factory {
  public View getView() {
    return new view.gui.Gui();
  }
}