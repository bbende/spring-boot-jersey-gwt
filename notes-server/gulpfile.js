var gulp = require('gulp');
var gulpif = require('gulp-if');
var concat = require('gulp-concat');
var minify = require('gulp-minify');
var cleanCss = require('gulp-clean-css');
var sass = require('gulp-sass');
var util = require('gulp-util');
var tildeImporter = require('node-sass-tilde-importer');

// Copy resources to the buildDir and use that as the source for other tasks
gulp.task('copy-css', function () {
    var srcDir = util.env.srcDir;
    var buildDir = util.env.buildDir;

    return gulp.src(srcDir + '/css/**/*.css')
        .pipe(gulp.dest(buildDir + '/css'));
});
gulp.task('copy-scss', function () {
    var srcDir = util.env.srcDir;
    var buildDir = util.env.buildDir;

    return gulp.src(srcDir + '/scss/**/*.scss')
        .pipe(gulp.dest(buildDir + '/scss'));
});

// The tilde-importer is required to resolve imports like ~bootstrap/scss/...
// The includePaths avoids the need to prefix all imports with the path to node_modules
gulp.task('compile-sass', ['copy-css', 'copy-scss'], function() {
    var buildDir = util.env.buildDir;

    return gulp.src(buildDir + '/scss/**/*.scss')
        .pipe(sass({
            includePaths: [ './node_modules' ],
            importer: tildeImporter
        }).on('error', sass.logError))
        .pipe(gulp.dest(buildDir + '/css/'));
});

// Since the bootstrap-material-custom.scss will re-build bootstrap-material, we only need to include the css
// directory from this project which will include bootstrap-material-custom.css built from bootstrap-material-custom.scss

gulp.task('pack-css', ['compile-sass'] , function () {
    var buildDir = util.env.buildDir;
    var outDir = util.env.outDir;
    var minifyFlag = util.env.envName === 'prod';

    return gulp.src(buildDir + '/css/**/*.css')
        .pipe(concat('stylesheet.css'))
        .pipe(gulpif(minifyFlag, cleanCss()))
        .pipe(gulp.dest(outDir + '/css'));
});

gulp.task('copy-index-html', function () {
    var srcDir = util.env.srcDir;
    var outDir = util.env.outDir;

    return gulp.src(srcDir + '/index.html')
        .pipe(gulp.dest(outDir + '/'));
});

gulp.task('default',
    [
        'pack-css',
        'copy-index-html'
    ]);

gulp.task('watch', function() {
    var srcDir = util.env.srcDir;

    gulp.watch([srcDir + '/scss/**/*.scss', srcDir + '/css/**/*.css'], ['pack-css']);
    gulp.watch(srcDir + '/index.html', ['copy-index-html']);
});