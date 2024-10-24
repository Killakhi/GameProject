package Engine;

import Level.Map;
import Level.MapTile;
import Level.Player;
import Level.TileType;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;
import java.util.Deque;
import java.util.stream.Collectors;

public class Pathfinder {
    protected Map map;

    public Pathfinder(Map map) {
        this.map = map;
    }

    public boolean isPassable(Point point) {
        MapTile tile = this.map.getMapTile(point.x, point.y);

        return tile == null
            ? false
            : tile.getTileType() == TileType.PASSABLE
        ;
    }

    public List<Route> getRouteExtensions(Route route, Point towards) {
        // there are four ways to go at most.
        // but really, as long as there is one point besides the route in the start already, there is only three sensible ways to go.

        //   *
        //  *S*
        //   *
        //
        // S = start
        // * = options

        // if there is a point though, there are only three sensible ways to go, since we never go immediately backwards.
        
        //  *
        // *-S
        //  *

        // in general, though, if the same point appears twice in the list, it means there is a loop, so that is also not an option.

        Point buildOffOfPoint = route.getLastStop();

        List<Point> neighbours = new ArrayList<>();

        neighbours.add(new Point(buildOffOfPoint.x + 0, buildOffOfPoint.y + 1)); // down
        neighbours.add(new Point(buildOffOfPoint.x + 0, buildOffOfPoint.y - 1)); // up
        neighbours.add(new Point(buildOffOfPoint.x + 1, buildOffOfPoint.y + 0)); // right
        neighbours.add(new Point(buildOffOfPoint.x - 1, buildOffOfPoint.y + 0)); // left

        neighbours.removeIf(point -> !this.isPassable(point)); // don't go through walls

        return neighbours.stream() // for each point
             // make new routes with each point added to the end
            .map(point -> route.andThen(point))
            // sort them by how likely they are to help us (minimum number of steps after this to get to our destination)
            .sorted(Comparator.comparingInt(extendedRoute -> (
                towards == null // if we have no destination, it doesn't matter
                    ? 0
                    : extendedRoute.getMinimumAdditionalMembers(towards)
            )))
            // ignore null routes (these were loops)
            .filter(e -> e != null)
            // collect them all to a list
            .collect(Collectors.toList());
    }

    public HashMap<Point, Route> allShortestPath(Point root) {
        HashMap<Point, Route> optimal = new HashMap<>();

        Route route = new Route();

        route.start = root;
        route.points = new ArrayList<>();

        optimal.put(root, route);

        Deque<Route> floodRoutes = new LinkedList<>();
        floodRoutes.push(route);

        while (!floodRoutes.isEmpty()) {
            // this loop body runs in O(1) time
            // this loop runs O(n) times where n is the number of times [1] is called
            // but [1] can only be called once for every point on the graph
            // so this whole method runs in linear time with respect to the number of squares on the graph

            Route optimalRouteToPivot = floodRoutes.removeFirst();

            // do a flood fill from this route
            for (Route extendedRoute : this.getRouteExtensions(optimalRouteToPivot, null)) {
                // this loop body takes constant time, O(1)
                // this loop runs between 1 and 4 times every time, so this loop runs in O(1) as well

                if (!optimal.containsKey(extendedRoute.getLastStop())) {
                    // this is the best route to get here
                    optimal.put(extendedRoute.getLastStop(), extendedRoute);
                    // add one more outer loop iteration [1]
                    floodRoutes.addLast(extendedRoute);
                } else {
                    // there is a better way to get to this point, and it will be investigated
                }
            }
        }

        return optimal;
    }

    protected Point cachedRouteOrigin = null;
    protected HashMap<Point, Route> cachedRouteTable = null;

    // you might want to call this if the map changes or something
    public void invalidateCachedRouteTable() {
        this.cachedRouteOrigin = null;
        this.cachedRouteOrigin = null;
    }

    public Route getBestRoute(Point player, Point enemyTile) {
        if (!player.equals(this.cachedRouteOrigin)) {
            // the player has moved
            this.invalidateCachedRouteTable();
        }

        if (this.cachedRouteOrigin == null) {
            this.cachedRouteOrigin = player;
            this.cachedRouteTable = this.allShortestPath(this.cachedRouteOrigin);
        }

        return this.cachedRouteTable.containsKey(enemyTile)
            ? this.cachedRouteTable.get(enemyTile).reversed()
            : null
        ;
    }

    public Route getBestRoute(Player player, Utils.Point enemyLocation) {
        Utils.Point playerPosition = player.getLocation();
        Utils.Point playerTileIndex = this.map.getTileIndexByPosition(playerPosition.x, playerPosition.y);
        Point playerPoint = new Point((int) (playerTileIndex.x), (int) (playerTileIndex.y));

        Utils.Point enemyTileIndex = this.map.getTileIndexByPosition(enemyLocation.x, enemyLocation.y);
        Point enemyPoint = new Point((int) (enemyTileIndex.x), (int) (enemyTileIndex.y));
    
        return getBestRoute(playerPoint, enemyPoint);
    }
}
