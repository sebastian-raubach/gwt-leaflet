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

package jhi.gwt.leaflet.client.basic;

import com.google.gwt.core.client.*;
import com.google.gwt.resources.client.*;

/**
 * @author Sebastian Raubach
 */
public class LeafletIcon extends JavaScriptObject
{
	protected LeafletIcon()
	{
	}

	/**
	 * Creates a {@link LeafletIcon} for the given map
	 *
	 * @return The newly created {@link LeafletIcon}
	 */
	public static LeafletIcon newInstance(String iconUrl, JsArrayInteger iconSize, JsArrayInteger iconAnchor, JsArrayInteger popupAnchor)
	{
		return createJso(iconUrl, iconSize, iconAnchor, popupAnchor).cast();
	}

	private static native JavaScriptObject createJso(String iconUrl, JsArrayInteger iconSize, JsArrayInteger iconAnchor, JsArrayInteger popupAnchor) /*-{
		return $wnd.L.icon({
			iconUrl: iconUrl,
			iconSize: iconSize,
			iconAnchor: iconAnchor,
			popupAnchor: popupAnchor
		});
	}-*/;

	public static LeafletIcon createFrom(ImageResource res)
	{
		JsArrayInteger size = JsArrayInteger.createArray().cast();
		size.push(res.getWidth());
		size.push(res.getHeight());
		JsArrayInteger anchor = JsArrayInteger.createArray().cast();
		anchor.push(Math.round(res.getWidth() / 2f));
		anchor.push(Math.round(res.getHeight() / 2f));
		JsArrayInteger popup = JsArrayInteger.createArray().cast();
		popup.push(0);
		popup.push(-Math.round(res.getHeight() / 2f));
		return LeafletIcon.newInstance(res.getSafeUri().asString(), size, anchor, popup);
	}
}
