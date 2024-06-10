# Work Log

## References and Resources
- Wikipedia: https://en.wikipedia.org/wiki/Hill_cipher
- Dcode: https://www.dcode.fr/hill-cipher
- Crypto Cornerr: https://crypto.interactive-maths.com/hill-cipher.html

## Charles Hua

### 5/22/24

Did research and made ciphers on paper to encode/decode.

### 5/23/24

Started coding the beginning of matrix multiplication.

### 5/24/24

Research on how to decode, how to get the inverse matrix.

### 5/28/24

Worked on mutiplying the first row by the column in encode.

### 5/30/24

Finished the matrix multiplication.

### 6/3/24

Worked on trying to be able to multiply when the plaintext was longer than 3 characters.

### 6/5/24

Finished encode for 2x2 and 3x3 keys.

### 6/7/24

Worked on splitting up and deciding what to present with the other group.

## 6/9/24

Finished the video, worked on presenation.md.


## Lisa Li

### 5/22/24

Created the basic files needed for our programs (makefile, encode/decode) as well as started making our test files.

### 5/23/24

Finished creating the first test files (plaintext, key, and ciphertext). Fixed the makefile to run ARGS. Starting to scan the files of the text files into their respective variables.

## 5/24/24

Successfully read the contents into strings and an integer array. Changed plaintext into vector (message to integer array).

## 5/28/24

Working on the decode method (translating ciphertext to int array). Started to work on inversing matrices by first seeing if there is an inverse by calculating the determinant. Was able to find the inverse matrix through determinant/cofactor matrix/adjacent matrix.

## 5/29/24

Completed the decode method (and check if inverse is possible) for 3X3 matrices but still need to test on other cases. Created test case for 2X2 matrices but may need to change the format of the key text files for it to work.

## 5/30/24

Changing the test files for the key to be letters instead of numbers. Will need to change how we parse the file.

## 5/31/24

Tested a case that won't work with the method to make sure all calculations are correct (no modular multiplicative inverse means you can't inverse the matrix with our method).

## 6/03/24

Make the ciphertext message longer than just 2 or 3 and still be able to decode the message. Did testing for 3x3s but still need to do testing for 2x2s.

## 6/05/24

Make more test cases (aka long 2x2 messages), add references/resources, planning presentation information, readme instructions.

## 6/07/24

Updating PRESENTATION.md, figuring out with the other group how we should split the topics for the video, as well as within my group. Filmed and edited the presentation video as well as updated extra information on the .md files.
