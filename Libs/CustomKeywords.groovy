
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject


def static "customKeywords.util.isFileDownloaded"(
    	String downloadPath	
     , 	String fileName	) {
    (new customKeywords.util()).isFileDownloaded(
        	downloadPath
         , 	fileName)
}

def static "customKeywords.util.getHeaderWithSpecCol"(
    	TestObject to	
     , 	String col_Index	) {
    (new customKeywords.util()).getHeaderWithSpecCol(
        	to
         , 	col_Index)
}

def static "customKeywords.util.getCellValueWithSpecCol"(
    	TestObject to	
     , 	String col_Index	
     , 	String row_Index	) {
    (new customKeywords.util()).getCellValueWithSpecCol(
        	to
         , 	col_Index
         , 	row_Index)
}

def static "customKeywords.util.clickSpecHeaderSpecTable"(
    	TestObject to	
     , 	String col_Index	) {
    (new customKeywords.util()).clickSpecHeaderSpecTable(
        	to
         , 	col_Index)
}

def static "html5.dnd.DragAndDropHelper.dragAndDrop"(
    	TestObject sourceObject	
     , 	TestObject destinationObject	) {
    (new html5.dnd.DragAndDropHelper()).dragAndDrop(
        	sourceObject
         , 	destinationObject)
}
