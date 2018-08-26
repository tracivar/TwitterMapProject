package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import org.openstreetmap.gui.jmapviewer.Style;

import java.awt.*;

public class MapMarkerMedium extends MapMarkerCircle {

    public static Image image;

    public void setImage(Image image) {
        this.image = image;
    }


    public MapMarkerMedium(Layer layer, String name, Coordinate coord, double radius, STYLE markerStyle, Style style) {
        super(layer, null, coord, radius, STYLE.FIXED, getDefaultStyle());
    }


    @Override
    public void paint(Graphics g, Point position, int radius) {
        int size = radius * 8;
        if (g instanceof Graphics2D && this.getBackColor() != null) {
            Graphics2D g2 = (Graphics2D)g;
            Composite oldComposite = g2.getComposite();
            g2.setComposite(AlphaComposite.getInstance(3));
            g2.setPaint(this.getBackColor());
            g.fillOval(position.x - radius, position.y - radius, size, size);
            g2.setComposite(oldComposite);
        }

        g.setColor(this.getColor());
        g.drawOval(position.x - radius, position.y - radius, size, size);
        if (this.getLayer() == null || this.getLayer().isVisibleTexts().booleanValue()) {
            this.paintText(g, position);
        }
        //System.out.println(tweet.getText());
        g.drawImage(this.image, position.x + radius, position.y + radius, size/2, size/2, null);

    }


}
