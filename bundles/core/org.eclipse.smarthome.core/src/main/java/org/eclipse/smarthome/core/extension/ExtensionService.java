/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.core.extension;

import java.util.List;
import java.util.Locale;

/**
 * Classes implementing this interface can be registered as an OSGi service in order to provide functionality for
 * managing extensions, such as listing, installing and uninstalling them.
 * The REST API offers an uri that exposes this functionality.
 *
 * @author Kai Kreuzer - Initial contribution and API
 *
 */
public interface ExtensionService {

    /**
     * Retrieves all extensions
     *
     * @param locale the locale to use for the result
     * @return the localized extensions
     */
    List<Extension> getExtensions(Locale locale);

    /**
     * Retrieves the extension for the given id.
     *
     * @param id the id of the extension
     * @param locale the locale to use for the result
     * @return the localized extension or null, if no extension exists with this id
     */
    Extension getExtension(String id, Locale locale);

    /**
     * Retrieves all possible types of extensions.
     *
     * @param locale the locale to use for the result
     * @return the localized types
     */
    List<ExtensionType> getTypes(Locale locale);

    /**
     * Installs the given extension.
     * This can be a long running process. The framework makes sure that this is called within a separate thread and
     * ExtensionEvents will be sent upon its completion.
     *
     * @param id the id of the extension to install
     */
    void install(String id);

    /**
     * Uninstalls the given extension.
     * This can be a long running process. The framework makes sure that this is called within a separate thread and
     * ExtensionEvents will be sent upon its completion.
     *
     * @param id the id of the extension to uninstall
     */
    void uninstall(String id);

}
