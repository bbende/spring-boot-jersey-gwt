var gulp = require('gulp');
var gulpif = require('gulp-if');
var concat = require('gulp-concat');
var minify = require('gulp-minify');
var cleanCss = require('gulp-clean-css');
var sass = require('gulp-sass');
var util = require('gulp-util');
var tildeImporter = require('node-sass-tilde-importer');

// The tilde-importer is required to resolve imports like ~bootstrap/scss/...
// The includePaths avoids the need to prefix all imports with the path to node_modules

gulp.task('compile-sass', function() {
    var srcDir = util.env.srcDir;

    gulp.src(srcDir + '/scss/**/*.scss')
        .pipe(sass({
            includePaths: [ './node_modules' ],
            importer: tildeImporter
        }).on('error', sass.logError))
        .pipe(gulp.dest(srcDir + '/css/'));
});

// Since the custom.scss will re-build bootstrap-material, we only need to include the css
// directory from this project which will include custom.css built from custom.scss

gulp.task('pack-css', function () {
    var srcDir = util.env.srcDir;
    var outDir = util.env.outDir;
    var minifyFlag = util.env.envName === 'prod';

    return gulp.src(srcDir + '/css/**/*.css')
        .pipe(concat('stylesheet.css'))
        .pipe(gulpif(minifyFlag, cleanCss()))
        .pipe(gulp.dest(outDir + '/css'));
});

gulp.task('copy-index-html', function () {
    var srcDir = util.env.srcDir;
    var outDir = util.env.outDir;

    gulp.src(srcDir + '/index.html')
        .pipe(gulp.dest(outDir));
});

gulp.task('default',
    [
        'compile-sass',
        'pack-css',
        'copy-index-html'
    ]);