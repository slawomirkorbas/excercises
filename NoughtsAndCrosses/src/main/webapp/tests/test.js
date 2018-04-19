var assert = require('assert');
var gameLogic = require('../gameLogic');

describe('Noughts&Crosses game Logic test...', function() {
    describe('#test diagonalPathCheck', function() {
        it('1 should return true when the field is considered as dead', function() {
            var matrix = [ [ 'O' , '' , 'X' ],
                           [ ''  , 'X', ''  ],
                           [ ''  , '' , 'O' ]
            ];

            assert.equal(verticalCheck(matrix,1,2),            true );
            assert.equal(horizontalCheck(matrix,1,2),          true );
            assert.equal(diagonalPathCheck(matrix,1,2, true),  true );
            assert.equal(diagonalPathCheck(matrix,1,2, false), true );
        });
    });

    describe('#test deadField', function() {
        it('1 should return true when the field is considered as dead', function() {
            var matrix = [ [ '' , 'X', '' ],
                           [ 'X', 'X', '' ],
                           [ '' , '' , '' ]
            ];

            assert.equal(deadField(matrix,0,0), true );
        });

        it('2 should return true when the field is considered as dead', function() {
            var matrix = [ [ 'O' , '' , 'X' ],
                           [ '' , 'X' , ''  ],
                           [ '' , ''  , 'O' ]
            ];

            assert.equal(deadField(matrix,0,1), true );
        });

        it('3 should return true when the field is considered as dead', function() {
            var matrix = [ [ 'O' , '' , 'X' ],
                           [ '' , 'X' , ''  ],
                           [ '' , ''  , 'O' ]
            ];

            assert.equal(deadField(matrix,1,2), true );
        });

        it('4 should return false when the field is considered as not dead', function() {
            var matrix = [ [ 'O' , '' , 'X' ],
                           [ '' , 'X' , ''  ],
                           [ '' , ''  , 'O' ]
            ];

            assert.equal(deadField(matrix,2,0), false );
        });

    });

});