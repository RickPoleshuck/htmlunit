/*
 * Copyright (c) 2002-2009 Gargoyle Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gargoylesoftware.htmlunit.javascript.host;

import org.mozilla.javascript.Undefined;

import com.gargoylesoftware.htmlunit.javascript.SimpleScriptable;

/**
 * A JavaScript object for a Location.
 *
 * @version $Revision: 4002 $
 * @author Ahmed Ashour
 * @see <a href="http://msdn.microsoft.com/en-us/library/6ch9zb09.aspx">MSDN Documentation</a>
 */
public class Enumerator extends SimpleScriptable {

    private static final long serialVersionUID = -7030539919126620376L;

    private int index_;

    private HTMLCollection collection_;

    /**
     * Creates an instance. JavaScript objects must have a default constructor.
     */
    public Enumerator() {
        // Empty.
    }

    /**
     * JavaScript constructor.
     * @param collection the collection object
     */
    public void jsConstructor(final HTMLCollection collection) {
        collection_ = collection;
    }

    /**
     * Returns whether the enumerator is at the end of the collection or not.
     * @return whether the enumerator is at the end of the collection or not
     */
    public boolean jsxFunction_atEnd() {
        return index_ >= collection_.getLength();
    }

    /**
     * Returns the current item in the collection.
     * @return the current item in the collection
     */
    public Object jsxFunction_item() {
        if (!jsxFunction_atEnd()) {
            return collection_.get(index_, collection_);
        }
        return Undefined.instance;
    }

    /**
     * Resets the current item in the collection to the first item.
     */
    public void jsxFunction_moveFirst() {
        index_ = 0;
    }

    /**
     * Moves the current item to the next item in the collection.
     */
    public void jsxFunction_moveNext() {
        index_++;
    }
}
