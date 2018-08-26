package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import twitter4j.Status;
import util.Util;

import java.awt.*;
import java.io.IOException;

public class MapMarkerSimple extends MapMarkerMedium{
    /*public static final double defaultMarkerSize = 5.0;
    public static final Color defaultColor = Color.red;

    public MapMarkerSimple(Layer layer, Coordinate coord) {
        super(layer, null, coord, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        setColor(Color.BLACK);
        setBackColor(defaultColor);
    }*/

    public static final double defaultMarkerSize = 5.0;
    public static final Color defaultColor = Color.red;
    // private ArrayList<MapMarkerSimple> markers = new ArrayList<>();
    public static Image image;

    public static Status tweet;


    public MapMarkerSimple(Layer layer, Coordinate coord, Color color, Status tweet) throws IOException {
        super(layer, null, coord, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        setColor(Color.BLACK);
        setBackColor(color);


        //setName(tweet.getText());
        this.tweet = tweet;

        //System.out.println(tweet.getUser().getMiniProfileImageURL());
        //URL imageURL = new URL(tweet.getUser().getProfileImageURL());
        this.image = Util.imageFromURL(tweet.getUser().getProfileImageURL());
        setImage(this.image);

    }



    public static Status getTweet() {
        return tweet;
    }






/*
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
        System.out.println(tweet.getText());
        g.drawImage(this.image, position.x + radius, position.y + radius, size/2, size/2, null);

    }
*/


/*    @Override
    public Iterator<MapMarker> iterator() {
        return new MapMarkerIterator();
    }

    private class MapMarkerIterator implements Iterator<MapMarker>{
        Iterator SimpleIterator = markers.iterator();

        @Override
        public boolean hasNext() {
            return SimpleIterator.hasNext();
        }

        @Override
        public MapMarker next() {
            MapMarkerSimple marker = (MapMarkerSimple) SimpleIterator.next();
            return marker;
        }
    }*/


}
