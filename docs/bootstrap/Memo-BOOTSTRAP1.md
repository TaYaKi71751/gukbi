# [Bootstrap](https://www.w3schools.com/bootstrap5/index.php)
## [Container Example 1](https://tayaki71751.github.io/gukbi/bootstrap/bootstrap01.html)
### [container](https://www.w3schools.com/bootstrap5/bootstrap_containers.php)
```
provides a responsive fixed width container
```
### container-fluid
```
provides a full width container, spanning the entire width of the viewport
```
### col-sm-4
- col: 열(column)을 설정한다는 의미
- sm: **작은 화면 이상(≥576px)**에서 적용    
- 4: 한 줄(row)을 12등분했을 때, 그 중 4칸을 차지한다는 뜻
### col-sm-8
- col: 열(column)을 설정한다는 의미
- sm: **작은 화면 이상(≥576px)**에서 적용    
- 8: 한 줄(row)을 12등분했을 때, 그 중 8칸을 차지한다는 뜻
## [Container Example 2](https://tayaki71751.github.io/gukbi/bootstrap/bootstrap02.html)
||Extra small<br>\<576px|Small<br>≥576px|Medium<br>≥768px|Large<br>≥992px|Extra Large<br>≥1200px|XXL<br>≥1400px|
|-|-|-|-|-|-|-|
|max-width|100%|540px|720px|960px|1140px|1320px|
## [Grid Example 1](https://tayaki71751.github.io/gukbi/bootstrap/bootstrap03)
### row and col
```html
!-- 고정 된 크기 3개의 컬럼 -->
<div class="container">
    <h1>3 Columns</h1>
    <p>Lorem ipsum dolor sit amet.</p>
    <div class="row">
        <div class="col bg-primary text-white">
            <h3>Column 1</h3>
        </div>
        <div class="col bg-dark text-white">
            <h3>Column 2</h3>
        </div>
        <div class="col bg-primary text-white">
            <h3>Column 3</h3>
        </div>
    </div>
</div>
```
### [Grid](https://www.w3schools.com/bootstrap5/bootstrap_grid_basic.php)
<table class="table grid">
<tbody><tr>
  <td>span 1</td>
  <td>span 1</td>  
  <td>span 1</td>
  <td>span 1</td>
  <td>span 1</td>  
  <td>span 1</td>
  <td>span 1</td>
  <td>span 1</td>  
  <td>span 1</td>
  <td>span 1</td>
  <td>span 1</td>  
  <td>span 1</td>
</tr>
<tr>
  <td colspan="4">&nbsp;span 4</td>
  <td colspan="4">&nbsp;span 4</td>  
  <td colspan="4">&nbsp;span 4</td>
</tr>
<tr>
  <td colspan="4">span 4</td>
  <td colspan="8">span 8</td>  
</tr>
<tr>
  <td colspan="6">span 6</td>
  <td colspan="6">span 6</td>  
</tr>
<tr>
  <td colspan="12">span 12</td>
</tr>
</tbody></table>

## Typography
```html
<!-- Headings -->
<!-- h1~h6 & Bolder font-weight -->
<p class="h1">h1 Bootstrap heading</p>
<p class="h2">h2 Bootstrap heading</p>
<p class="h3">h3 Bootstrap heading</p>
<p class="h4">h4 Bootstrap heading</p>
<p class="h5">h5 Bootstrap heading</p>
<p class="h6">h6 Bootstrap heading</p> 
```
```html
<!-- Display Headings -->
<!-- Larger font-size & Lighter font-weight -->
<h1 class="display-1">Display 1</h1>
<h1 class="display-2">Display 2</h1>
<h1 class="display-3">Display 3</h1>
<h1 class="display-4">Display 4</h1>
<h1 class="display-5">Display 5</h1>
<h1 class="display-6">Display 6</h1>
```
## [Colors](https://www.w3schools.com/bootstrap5/bootstrap_colors.php)
## [Table](https://www.w3schools.com/bootstrap5/bootstrap_tables.php)
### .table
### .table-striped
### .table-bordered
### .table-hover
### .table-dark
## [Images](https://www.w3schools.com/bootstrap5/bootstrap_images.php)
### .rounded
`Adds rounded corners to an image`
### .rounded-circle
`Shapes the image to a circle`
### .img-thumbnail
`Shapes the image to a thumbnail (bordered)`
### .float-start
`Float an image to the left`
### .float-end
`Float an image to the right`
### .img-fluid
`Responsive Images`
