## Dish-Fish 
# Lire-application for image recognition using CBIR 
This is a proposed solution for detecting pictures of recipes from a picture of fish or seafood.
This implementation is based on the LIRE library and follows many of classes and implementation used in that one.
It uses  ***Discrete Fourier Transform (DFT)*** to create a magnitude and phase spectrum for image comparison.

## Datasets 
Inside the folder datasets there are a list of images that are used as datasets, inside each category folder there is a sample folder that we use as a __query image__.

## Src folder 
Inside this folder we can find the implemented classes
+ **LireMetadata** class of the metafile for the recipes 
+ **IndexingAndSearchWithLocalFeatures** Class for indexing and searchin with local features
+ **CvDFT** Class for the Discrete Fourier Transform (DFT) with opencv
