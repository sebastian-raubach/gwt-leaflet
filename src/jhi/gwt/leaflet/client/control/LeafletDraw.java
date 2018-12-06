/*
 *  Copyright 2018 Sebastian Raubach from the Information
 *  and Computational Sciences Group at JHI Dundee
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package jhi.gwt.leaflet.client.control;

import com.google.gwt.core.client.*;

import jhi.gwt.leaflet.client.basic.*;
import jhi.gwt.leaflet.client.map.*;

/**
 * @author Sebastian Raubach
 */
public class LeafletDraw extends JavaScriptObject implements LeafletControl
{
	protected LeafletDraw()
	{
	}

	public static LeafletDraw newInstance(LeafletMap map, LeafletControlPosition position)
	{
		return createJso(map, position.getPosition()).cast();
	}

	private static native JavaScriptObject createJso(LeafletMap map, String position) /*-{
		var editableLayers = new $wnd.L.FeatureGroup();
		map.addLayer(editableLayers);

		var options = {
			position: position,
			draw: {
				polyline: false,
				circle: false,
				rectangle: false,
				marker: false,
				polygon: {
					allowIntersection: false,
					drawError: {
						color: '#c0392b'
					}
				}
			},
			edit: {
				featureGroup: editableLayers, //REQUIRED!!
				remove: true
			}
		};

		var result = new $wnd.L.Control.Draw(options);
		map.addControl(result);

		map.on($wnd.L.Draw.Event.CREATED, function (e) {
			var layer = e.layer;

			editableLayers.clearLayers();
			editableLayers.addLayer(layer);
		});

		return {draw: result, layers: editableLayers};
	}-*/;

	public final native JsArray<LeafletLatLng> getPolygon() /*-{
		var polygon = [];

		this.layers.eachLayer(function (layer) {
			var latLngs = layer.getLatLngs()[0];
			for (var i = 0; i < latLngs.length; i++)
				polygon.push(latLngs[i]);
		});

		return polygon;
	}-*/;
}
