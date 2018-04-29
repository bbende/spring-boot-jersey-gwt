var gulp = require('gulp');
var gulpif = require('gulp-if');
var concat = require('gulp-concat');
var minify = require('gulp-minify');
var cleanCss = require('gulp-clean-css');
var util = require('gulp-util');

gulp.task('pack-css', function () {
    var srcDir = util.env.srcDir;
    var outDir = util.env.outDir;
    var minifyFlag = util.env.envName === 'prod';

    return gulp.src([
            'node_modules/bootstrap-material-design/dist/css/bootstrap-material-design.css',
            srcDir + '/css/**/*.css'
        ])
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
        'pack-css',
        'copy-index-html'
    ]);