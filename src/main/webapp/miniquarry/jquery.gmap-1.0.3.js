(function ($) {
    $.fn.gMap = function (options) {
        if (!window.GBrowserIsCompatible || !GBrowserIsCompatible()) {
            return this
        }
        var opts = $.extend({}, $.fn.gMap.defaults, options);
        return this.each(function () {
            $gmap = new GMap2(this);
            if (!opts.latitude && !opts.longitude) {
                if (is_array(opts.markers) && opts.markers.length >= 1) {
                    opts.latitude = opts.markers[0].latitude;
                    opts.longitude = opts.markers[0].longitude
                } else {
                    opts.latitude = 34.885931;
                    opts.longitude = 9.84375;
                    opts.zoom = 2
                }
            }
            $gmap.setCenter(new GLatLng(opts.latitude, opts.longitude), opts.zoom);
            $gmap.setMapType(opts.maptype);
            if (opts.controls.length == 0) {
                $gmap.setUIToDefault()
            } else {
                for (var i = 0; i < opts.controls.length; i++) {
                    eval("$gmap.addControl(new " + opts.controls[i] + "());")
                }
            }
            if (opts.scrollwheel == true && opts.controls.length != 0) {
                $gmap.enableScrollWheelZoom()
            }
            for (var j = 0; j < opts.markers.length; j++) {
                marker = opts.markers[j];
                gicon = new GIcon();
                gicon.image = opts.icon.image;
                gicon.shadow = opts.icon.shadow;
                gicon.iconSize = (is_array(opts.icon.iconsize)) ? new GSize(opts.icon.iconsize[0], opts.icon.iconsize[1]) : opts.icon.iconsize;
                gicon.shadowSize = (is_array(opts.icon.shadowsize)) ? new GSize(opts.icon.shadowsize[0], opts.icon.shadowsize[1]) : opts.icon.shadowsize;
                gicon.iconAnchor = (is_array(opts.icon.iconanchor)) ? new GPoint(opts.icon.iconanchor[0], opts.icon.iconanchor[1]) : opts.icon.iconanchor;
                gicon.infoWindowAnchor = (is_array(opts.icon.infowindowanchor)) ? new GPoint(opts.icon.infowindowanchor[0], opts.icon.infowindowanchor[1]) : opts.icon.infowindowanchor;
                if (marker.icon) {
                    gicon.image = marker.icon.image;
                    gicon.shadow = marker.icon.shadow;
                    gicon.iconSize = (is_array(marker.icon.iconsize)) ? new GSize(marker.icon.iconsize[0], marker.icon.iconsize[1]) : marker.icon.iconsize;
                    gicon.shadowSize = (is_array(marker.icon.shadowsize)) ? new GSize(marker.icon.shadowsize[0], marker.icon.shadowsize[1]) : marker.icon.shadowsize;
                    gicon.iconAnchor = (is_array(marker.icon.iconanchor)) ? new GPoint(marker.icon.iconanchor[0], marker.icon.iconanchor[1]) : marker.icon.iconanchor;
                    gicon.infoWindowAnchor = (is_array(marker.icon.infowindowanchor)) ? new GPoint(marker.icon.infowindowanchor[0], marker.icon.infowindowanchor[1]) : marker.icon.infowindowanchor
                }
                gmarker = new GMarker(new GPoint(marker.longitude, marker.latitude), gicon);
                if (marker.html) {
                    gmarker.bindInfoWindowHtml(opts.html_prepend + marker.html + opts.html_append);
                    if (gmarker) {
                        $gmap.addOverlay(gmarker)
                    }
                    if (marker.popup == true) {
                        gmarker.openInfoWindowHtml(opts.html_prepend + marker.html + opts.html_append)
                    }
                } else {
                    if (gmarker) {
                        $gmap.addOverlay(gmarker)
                    }
                }
            }
        })
    };
    function is_array(input) {
        return typeof(input) == "object" && (input instanceof Array)
    }

    $.fn.gMap.defaults = {latitude: 0, longitude: 0, zoom: 6, markers: [], controls: [], scrollwheel: true, maptype: G_NORMAL_MAP, html_prepend: '<div class="gmap_marker">', html_append: "</div>", icon: {image: "http://www.google.com/mapfiles/marker.png", shadow: "http://www.google.com/mapfiles/shadow50.png", iconsize: [20, 34], shadowsize: [37, 34], iconanchor: [9, 34], infowindowanchor: [9, 2]}}
})(jQuery);
