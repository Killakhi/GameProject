package Engine;

import java.awt.Point;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Route {
    public Point start;
    public List<Point> points;

    // returns false if there are loops.
    public boolean isSensible() {
        if (this.points.contains(start)) {
            return false;
        }

        HashSet<Point> set = new HashSet<>();

        for (Point point : this.points) {
            if (set.contains(point)) {
                // there is a duplicate
                return false;
            }

            set.add(point);
        }

        return true;
    }

    // get the last point in this route
    public Point getLastStop() {
        return this.points.isEmpty() ? this.start : this.points.get(this.points.size() - 1);
    }

    // the naive best case distance from the last point to the destination
    public int getMinimumAdditionalMembers(Point dst) {
        Point src = this.getLastStop();

        return Math.abs(src.x - dst.x) + Math.abs(src.y - dst.y);
    }

    public Route andThen(Point next) {
        Route newRoute = new Route();

        newRoute.start = new Point(this.start);
        newRoute.points = this.points.stream().collect(Collectors.toList());

        newRoute.points.add(next);

        return newRoute.isSensible() ? newRoute : null;
    }

    public Route reversed() {
        Route reversedRoute = new Route();

        reversedRoute.start = this.getLastStop();

        reversedRoute.points = this.points.stream().collect(Collectors.toList());
        Collections.reverse(reversedRoute.points);

        reversedRoute.points.add(this.start);
        // get rid of the first reversed point, since it should actually be in reversedRoute.start
        reversedRoute.points.remove(0);

        return reversedRoute;
    }

    public Point getDirectionToMove() {
        if (this.points.isEmpty()) {
            return new Point(0, 0);
        }

        Point next = this.points.get(0);

        return new Point(
            next.x - this.start.x,
            next.y - this.start.y
        );
    }
}
